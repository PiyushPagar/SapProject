import React from 'react';
import { Redirect } from 'react-router-dom';

function SuperAuth(Component) {
   
  function AuthGuard(props) {
    if(localStorage.getItem('role') !== 'ROLE_SUPER_ADMIN' ){
    //const isAuthenticated = false; // replace with your authentication logic
    
      return <Redirect to="/login" />;
  }
  else {
    if(localStorage.getItem('role') === 'ROLE_SUPER_ADMIN'){
        return <Component {...props} />;
    }}
  
  }
    
  
  return AuthGuard;}


export default SuperAuth;