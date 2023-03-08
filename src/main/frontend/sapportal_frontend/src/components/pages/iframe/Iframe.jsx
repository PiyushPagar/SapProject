import React, { useState } from "react";

import "./Iframe.css";

const Iframe = () => {
  const [youtubeID] = useState("lX3OIuT_zYM");
  return (
    <div className="v-main">
      <iframe
        className="video"
        title="Youtube player"
        sandbox="allow-same-origin allow-forms allow-popups allow-scripts allow-presentation"
        src={`https://youtube.com/embed/${youtubeID}?autoplay=0`}
      ></iframe>
      <div className="v-right">
        <h1 className="v-h1">Description</h1>
        <p>
          This is an introductory video by Dr.A.B.Pawar, Dean Acacdemics, Sanjivani College of Engineering, Kopargaon.
          This video will give you an idea about SAP.
        </p>
      </div>
    </div>
  );
};

export default Iframe;
