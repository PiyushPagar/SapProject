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
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit
          quisquam esse perferendis sit, accusantium, quibusdam exercitationem
          tenetur reiciendis officia eum nam cupiditate vero nisi aperiam magni!
          Error sunt sapiente dolorum, illum, aspernatur quae maiores veniam
          quas est blanditiis distinctio minima? Autem saepe id asperiores
          eligendi ratione. In at ullam est commodi laborum! Natus, laborum sed!
          Magnam.
        </p>
      </div>
    </div>
  );
};

export default Iframe;
