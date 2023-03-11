import React,{useEffect,useState} from 'react';
import "./NewNav.css"


const NewNav = () => {
    const a= "super";
    const b="true";
const [nag, setnag] = useState();

    const callAboutPage = async () => {
        try {
          const response = await fetch("/time", {
            mode: 'no-cors',
            method: "GET",
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            },
            credentials: "include",
          });
          const data = response;
          const data1 = await response.json();
          console.log();
        
          setnag(data1[0].name);
          
          
       
    
          if (data.status !== 200) {
            const error = new Error(response.error);
            throw error;
          }
        } catch (err) {
          console.log(err);
        }
      };
      useEffect(() => {
       
        callAboutPage();
      },[]);


    return (
        <div>
            {/* {nag=="Sachin"? */}
            <div>

           
          <div className='new-nav'>
            <h2>Sanjivani
            <span className='color-teal'>
                SAP
                </span> </h2>
            <h2>
            Welcome To {a}

            </h2>
            <button>
                LogOut
            </button>
          </div>
          <div className='compo-down'>
            <div className="left-nav">
                {a=="admin"?<p>Admin</p>:<p>{
                a=="super"?<p>Super</p>:<p>User</p>}</p>}
                <div className='left-content'>Appid</div>
                <div className='left-content'>Payment</div>
                <div className='left-content'>Course</div>
                

                {/* label for="cars">Choose a car:</label> */}

                {a=="admin"?<div className='left-drop'>


<select className='left-content new-nav-drop' name="cars" id="cars">
  <option value="volvo">App. Form</option>
  <option value="saab">Verify Form</option>
  <option value="mercedes">Search form</option>
  <option value="audi">Delete Form</option>
</select>
<select className='left-content new-nav-drop' name="cars" id="cars">
  <option value="volvo">Notification</option>
  <option value="saab">Add Notification</option>
  <option value="mercedes">Delete Notification</option>
  <option value="audi">Update Notification</option>
</select>
<select className='left-content new-nav-drop' name="cars" id="cars">
  <option value="volvo">Placement</option>
  <option value="saab">Add Placement</option>
  
</select>
                </div>

  :<p>
   {a=="super"?
   <div className='left-drop'>


   <select className='left-content new-nav-drop' name="cars" id="cars">
     <option value="volvo">App. Form</option>
     <option value="saab">Verify Form</option>
     <option value="mercedes">Search form</option>
     <option value="audi">Delete Form</option>
   </select>
   <select className='left-content new-nav-drop' name="cars" id="cars">
     <option value="volvo">Notification</option>
     <option value="saab">Add Notification</option>
     <option value="mercedes">Delete Notification</option>
     <option value="audi">Update Notification</option>
   </select>
   <select className='left-content new-nav-drop' name="cars" id="cars">
     <option value="volvo">Placement</option>
     <option value="saab">Add Placement</option>
     
   </select>
   <select className='left-content new-nav-drop' name="cars" id="cars">
     <option value="volvo">Admin</option>
     <option value="saab">Create Admin</option>
     <option value="saab">Delete Admin</option>
     
   </select>
                   </div>:<p></p>
  } 
    
    
    </p>}
            </div>
            <div className="right-nav">right</div>
          </div>

           
          </div>
          {/* :<div>Not Verfied</div>} */}
        </div>
    );
}

export default NewNav;
