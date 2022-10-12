import React from "react";
import "./Placement.css";
import {useEffect, useState} from "react";
import Navbar from "../Navbar";
import Footer from "./Footer";
const Seemore = () => {
     const [users, setUsers] = useState([]);

   const getUsers= async ()=>{
    const res = await fetch('https://ecombackend.sonarpratik.repl.co/api/product');
    setUsers(await res.json());
    // const data =await res.json();
    // console.log(data);
    
   }
    useEffect(() => {
        getUsers();
        
    }, []);

  return (
    <div>
      <Navbar/>
      <h1 className="center-p">Placement</h1>

      <div className="main-Placement">
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
      <Footer/>
    </div>
  );
};

export default Seemore;
