package com.youxianqin.dockermgr.shiro;






import com.youxianqin.dockermgr.dao.*;
import com.youxianqin.dockermgr.models.*;
import com.youxianqin.dockermgr.service.BaseRoleService;
import com.youxianqin.dockermgr.service.PermissionService;
import com.youxianqin.dockermgr.service.RoleUserService;
import com.youxianqin.dockermgr.service.ServiceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 自定义Realm,进行数据源配置
 * 
 * @author lanyuan 2014-12-25
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BaseRoleMapper baseRoleMapper;

	@Autowired
	private RoleUserMapper roleUserMapper;


	@Autowired
	private ServiceMapper serviceMapper;

	@Autowired
	private BaseRolePermissionMapper baseRolePermissionMapper;

	@Autowired

	private PermissionMapper permissionMapper;

	final Logger log = LoggerFactory.getLogger(MyRealm.class);

	/**
	 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		if (loginName != null) {
			String userId = SecurityUtils.getSubject().getSession().getAttribute("userSessionId").toString();
			int id;
			try {
				id = Integer.parseInt(userId);
			}catch (NumberFormatException e) {
				return null;
			}

			List<RoleUser> rs = roleUserMapper.getEntityByUser(id);
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<BaseRolePermission> baseRolePermissions = baseRolePermissionMapper.getEntity();
			List<Permission> permissions = permissionMapper.getEntity();
			List<BaseRole> baseRoles = baseRoleMapper.getEntity();
			List<Service> services = serviceMapper.getEntity();
			// 用户的角色集合
			// info.addRole("default");
			// 用户的角色集合
			// info.setRoles(user.getRolesName());
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限
			for (RoleUser resource : rs) {
				BaseRole role = null;
				Service service = null;
				List<Permission> permissionList = new ArrayList<Permission>();
				for (BaseRole baseRole:baseRoles) {
					if (resource.getBaseRoleId() == baseRole.getId()) {
						role = baseRole;
						break;
					}
				}
				if (role == null) continue;
				for (Service service1:services) {
					if (resource.getServiceId() == service1.getId()) {
						service = service1;
						break;
					}
				}
				if (role.getCrossService() && service == null) continue;
				if (!role.getCrossService() && service != null) continue;
				for (BaseRolePermission baseRolePermission:baseRolePermissions) {
					if (resource.getBaseRoleId() == baseRolePermission.getBaseRoleId()) {

						for (Permission permission : permissions) {
							if (permission.getId() == baseRolePermission.getPermissionId()) {
								permissionList.add(permission);
								break;
							}
						}
						break;
					}
				}

				for (Permission permission:permissionList) {
					if (role.getCrossService() != permission.getCrossService()) {
						continue;
					}
					StringBuilder PermSB =  new StringBuilder();
					if (role.getCrossService()) {
						PermSB.append(service.getCode()).append("-");

					}
					PermSB.append(permission.getName()).append(":").append(permission.getMethod());
					log.debug(PermSB.toString());
					info.addStringPermission(PermSB.toString());
				}


			}


			return info;
		}

		return null;
	}

	/**
	 * 认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();


		User user = userMapper.getEntityByName(username);

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes( "youxian"),// salt=username+salt
				getName() // realm name
		);
			// 当验证都通过后，把用户信息放在session里

		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userSession", user);
		session.setAttribute("userSessionId", user.getId());
		return authenticationInfo;
	}
	/**
     * 更新用户授权信息缓存.
     */
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
     * 更新用户信息缓存.
     */
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	/**
	 * 清除用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 清除用户信息缓存.
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}
	
	/**
	 * 清空所有缓存
	 */
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}


	/**
	 * 清空所有认证缓存
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}