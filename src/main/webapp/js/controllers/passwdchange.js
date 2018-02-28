'use strict';

// signup controller
app.controller('PassWdChangeFormController', ['$scope', '$http', '$state','authService',function($scope, $http, $state,authService) {
    $scope.user = {};
    $scope.authError = null;
    $scope.user.username = authService.returnUser();
    console.log($scope.user.username)
    $scope.signup = function() {
      $scope.authError = null;
      // Try to create
      if ($scope.user.username == undefined) {
        $scope.authError = "请先登录";
        $state.go('access.signin');
      } else 
      if ($scope.user.password !== $scope.user.repassword) {
        $scope.authError = "password not match";
        return
      }
	  delete $scope.user["repassword"]
      $http.put('/api/user/passwdchange', $scope.user)
      .then(function(response) {
        if ( !response.data.status ) {
          $scope.authError = response.data.info;
        }else{
          $state.go('docker.dashboard');
        }
      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };
  }])
 ;
