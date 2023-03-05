import React from "react";
import "./Placement.css";
import {useEffect, useState} from "react";
import Navbar from "../Navbar";
import Footer from "./Footer";
import ClimbingBoxLoader from "react-spinners/ClimbingBoxLoader";

const Seemore = () => {
     const [users, setUsers] = useState([]);
const [loading , setLoading] =useState(false);

   const getUsers= async ()=>{
    const res = await fetch('https://ecombackend.sonarpratik.repl.co/api/product');
    setLoading(true)
    setUsers(await res.json());
    // const rrrr=res.json();
    console.log(await users.body)
setTimeout(() => {
  setLoading(false)
}, 3000);

// if(users===null){
//   setLoading(true)
// }

    // const data =await res.json();
    // console.log(data);
    
   }
    useEffect(() => {
        getUsers();
        
    }, [getUsers]);

  return (
    <div>
     

      <Navbar/>
      <h1 className="center-p">Placement</h1>

      <div >
      {
            loading ?
            <ClimbingBoxLoader

            color={"#36d7b7"}
            loading={loading}
            size={35}
            className="center-spinner" 
          />
            :
            <div className="main-Placement">

{
    users.map((cur)=>{
        return(

        
        <div  className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
          

        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
{
    users.map((cur)=>{
        return(

        <div className="con-p"  data-aos="fade-right"  data-aos-delay="50">
        <img src={cur.img} className="my-pic" alt="" />
        <h2>{cur.title}</h2>
        <h3>Google</h3>
        <p>Web Developer</p>
        <p>1200000 lpa</p>
      </div>
        )
    })
}
</div>
}
       
      </div>
      <Footer/>
      </div>


  );
};

export default Seemore;
