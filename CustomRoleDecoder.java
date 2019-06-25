package org.wildfly.security.authz;
import java.util.ArrayList;
import java.util.HashMap;
public class CustomRoleDecoder implements RoleDecoder{
//A HashMap has to be populated beforehand with relevant key,value pair for use 
    HashMap<String, Set<String>> roleMap;
    CustomRoleDecoder(){
        roleMap = new roleMap<>(); //needs to populated as required
    }
    Roles decodeRoles(AuthorizationIdentity authorizationIdentity){
        return decodeRolesHelper(authorizationIdentity,roleMap); 
    }
    Roles decodeRolesHelper(AuthorizationIdentity authorizationIdentity, HashMap<String, Set<String>> roleMap){
        Attributes attribute = authorizationIdentity.getAttributes(); 
        String attributeKey = attribute.getFirst(“department”) //key attribute corresponding to the desired attribute kind
        Set<String> roles = roleSet.get(attributeKey);
        Roles roleTemp = new Roles(); 
        return roleTemp.fromSet(roles); 
    }
}
