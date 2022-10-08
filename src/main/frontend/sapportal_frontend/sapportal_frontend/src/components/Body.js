import React from "react";
import styled from "styled-components";
import Video from "./pages/Video";



const Conatainer = styled.div`
overflow:hidden;

`
const Img = styled.img`
  width:100%;
  height: calc(100vh - 60px);
  vertical-align: middle;



`


function Body() {
  return (
    <Conatainer>
      <div className="f-wrapper">
      <Video />
    
      </div>
      <Img className="img1" src="Photo/College.jpg" />

    </Conatainer>
    
  )
}

/* CSS FOR THIS PAGE */


export default Body;