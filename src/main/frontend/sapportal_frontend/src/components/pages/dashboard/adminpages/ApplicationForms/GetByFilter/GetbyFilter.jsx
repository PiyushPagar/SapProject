import React from "react";
import { useState } from "react";
//import { Dropdown, DropdownButton } from "react-bootstrap";
const GetbyFilter = () => {
    const [showid, setshowid] = useState(false)
    const handleselect = (e) => {
        console.log(e.target.value)
        if(e.target.value === "userid" ){
            setshowid(true)
        }
    }
    
    
    return (
        <div>
           <select name="cars" id="cars" onChange={handleselect}>
    <option value="volvo">Volvo</option>
    <option value="userid">User Id</option>
    <option value="opel">Opel</option>
    <option value="audi">Audi</option>
  </select>


  {
          showid &&  <>
            <div className="container">
                Hii
            </div>
            <div></div></>
          
        }
        </div>
    )
}

export default GetbyFilter;