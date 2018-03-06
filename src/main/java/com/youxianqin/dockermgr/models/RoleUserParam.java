package com.youxianqin.dockermgr.models;

import java.util.ArrayList;
import java.util.List;

public class RoleUserParam {

        ArrayList<User> users;
        BaseRole baseRole;
        Service service;

        public BaseRole getBaseRole() {
            return baseRole;
        }

        public void setBaseRole(BaseRole baseRole) {
            this.baseRole = baseRole;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(ArrayList<User> users) {
            this.users = users;
        }

        public Service getService() {
            return service;
        }

        public void setService(Service service) {
            this.service = service;
        }

}
