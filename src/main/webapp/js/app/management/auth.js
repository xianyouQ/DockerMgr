app.controller('ManageMentAuthCtrl', ['$scope', '$http', '$filter','$modal','toaster',function($scope, $http, $filter,$modal,toaster) {
function isObjectValueEqual(a, b) {
   if(a.Id === b.Id){
     return true;
   } 
   else {
     return false;
   }
}

  Array.prototype.contains = function(obj) {
    var i = this.length;
    while (i--) {
        if (isObjectValueEqual(this[i],obj)) {
            return true;
        }
    }
    return false;
 }

 Array.prototype.remove=function(obj){ 
  for(var i =0;i <this.length;i++){ 
    var temp = this[i]; 
    if(!isNaN(obj)){ 
      temp=i; 
    } 
    if(isObjectValueEqual(temp,obj)){ 
      for(var j = i;j <this.length;j++){ 
        this[j]=this[j+1]; 
        } 
      this.length = this.length-1; 
      } 
  } 
  }
    $scope.roles = [];
    $scope.selectedrole = null;
    $scope.nodes = [];
    $http.get('/api/permission').then(function (resp) {
      if (resp.data.status ){
        $scope.nodes = resp.data.data;
      }
      else {
        toaster.pop("error","get node error",resp.data.info);
      } 
  });
    $http.get('/api/baserole').then(function (resp) {
      if (resp.data.status ){
        $scope.roles = resp.data.data;

      }
      else {
        toaster.pop("error","get auth error",resp.data.info);
      } 
  });

  $scope.selectRole = function (item) {
    angular.forEach($scope.roles, function(role) {
      role.selected = false;
    });
      angular.forEach($scope.nodes,function(innernode){
        var skip = false;
        angular.forEach(item.nodes,function(node){
        if(innernode.id == node.id) {
          innernode.Active = true;
          skip = true;
        } 
      });
      if(skip == false){
        innernode.Active = false;
      }
    });
    $scope.selectedrole = item;
    $scope.selectedrole.selected = true;
  };
  $scope.createRole = function () {
      var modalInstance = $modal.open({
        templateUrl: 'addRoleModalContent.html',
        controller: 'addRoleModalInstanceCtrl',
        size: 'lg',
      });
 
      modalInstance.result.then(function (newAuth) {
        $scope.roles.push(newAuth);
      }, function () {
        //log error
      });
  };
  $scope.delRole = function(item) {
      var modalInstance = $modal.open({
        templateUrl: 'delRoleConfirmModalContent.html',
        controller: 'delRoleConfirmModalInstanceCtrl',
        size: 'lg',
        resolve: {
          delRole: function () {
            return item;
          }
        }
      });
  modalInstance.result.then(function (delRole) {
        $scope.roles.remove(delRole);
      }, function () {
        //log error
      });
  };
  $scope.createNode = function () {
      var modalInstance = $modal.open({
        templateUrl: 'addNodeModalContent.html',
        controller: 'addNodeModalInstanceCtrl',
        size: 'lg',
      });
 
      modalInstance.result.then(function (newNode) {
        $scope.nodes.push(newNode);
      }, function () {
        //log error
      });
  };

  $scope.CommitAuth = function() {
    var temprole = {};
    $.extend(true,temprole,$scope.selectedrole);
    if(temprole.permissionList === null) {
      temprole.permissionList = [];
    }
    console.log(temprole)
    angular.forEach($scope.nodes,function(innernode){
      var skip = false;
      angular.forEach(temprole.permissionList,function(node){
      if(node.id == innernode.id){
        node.chosen = innernode.chosen;
        skip = true;
      }

      });
      if (innernode.chosen == true && skip == false){
        temprole.permissionList.push(innernode);
      }
    });
    $http.post('/api/baserolepermission',temprole).then(function(resp){
          if (resp.data.status ){
            $scope.selectedrole = temprole;
          }
          else {
            console.log(resp.data.info)
          }
    });
  };


}]);

  app.controller('addRoleModalInstanceCtrl', ['$scope', '$modalInstance','$http',function($scope, $modalInstance,$http) {
    $scope.newRole = {"name":"","crossService":false};
    $scope.formError = null;
    $scope.ok = function () {
      $scope.formError = null;
      if ($scope.newRole.name == ""){
        return
      }
        $http.post('/api/baserole',$scope.newRole).then(function(response) {
          if (response.data.status ){
            $modalInstance.close(response.data.data);
          }
          if  (!response.data.status ) {
            $scope.formError = response.data.info;
          }
        }, function(x) {
        $scope.formError = 'Server Error';
      });
      
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
  }]); 

    app.controller('addNodeModalInstanceCtrl', ['$scope', '$modalInstance','$http',function($scope, $modalInstance,$http) {
    $scope.newNode = {"name":"","comment":"","url":"","crossService":false};
    $scope.formError = null;
    $scope.ok = function () {
      $scope.formError = null;
      if ($scope.newNode.comment == "" || $scope.newNode.url == ""||$scope.newNode.name == ""){
        return
      }
        $http.post('/api/permission',$scope.newNode).then(function(response) {
          if (response.data.status ){
            $modalInstance.close(response.data.data);
          }
          if  (!response.data.status ) {
            $scope.formError = response.data.info;
          }
        }, function(x) {
        $scope.formError = 'Server Error';
      });
      
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
  }]); 


    app.controller('delRoleConfirmModalInstanceCtrl', ['$scope', '$modalInstance','$http','delRole',function($scope, $modalInstance,$http,$delRole) {
    $scope.formError = null;
    $scope.confirm="delete role?";
    $scope.ok = function () {
      $scope.formError = null;
     $http.get('/api/baserole/'+$delRole.id).then(function(response) {
          if (response.data.status){
            $modalInstance.close($delRole);
          }
          if  (!response.data.status ) {
            $scope.formError = response.data.info;
          }
        }, function(x) {
        console.log('Server Error')
      });
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
  }]); 