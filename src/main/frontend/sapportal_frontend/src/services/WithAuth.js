import React from 'react';
import { Redirect } from 'react-router-dom';

function withAuth(Component) {
   
  function AuthGuard(props) {
    if(localStorage.getItem('token') === null){
    //const isAuthenticated = false; // replace with your authentication logic
    
      return <Redirect to="/login" />;
  }
  else {
    if(localStorage.getItem('token') !== null){
        return <Component {...props} />;
    }}
  
  }
    
  
  return AuthGuard;}


export default withAuth;