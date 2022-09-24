import React from "react";
import styled from "styled-components";



const Conatainer = styled.div`
overflow:hidden;

`
const Img = styled.img`
  width:100%;
  height: calc(100vh - 60px);
  vertical-align: middle;



`


function Footer() {
  return (
    <Conatainer>
      <div className="f-wrapper">
    this is sanh
    
      </div>
      <Img className="img1" src="Photo/College.jpg" />

    </Conatainer>
    
  )
}

/* CSS FOR THIS PAGE */


export default Footer;