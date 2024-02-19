import { useState } from "react";
import "./App.css";

export default function App() {
  const [pressLike, setBtnLike] = useState(0);
  const [pressHate, setBtnHate] = useState(0);

  function countLikes() {
    setBtnLike((pressLike) => pressLike + 1);
  }

  function countHates() {
    setBtnHate((pressHate) => pressHate + 1);
  }

  function resetCounters() {
    setBtnLike((pressLike) => 0);
    setBtnHate((pressHate) => 0);
  }

  return (
    <div className="card">
      <img
        src="https://miro.medium.com/v2/resize:fit:1200/1*hm7aE3BdUfUWUgBYK1GiZA.jpeg"
        className="card-body"
        alt="React conding language logo with How I fell in love with React text"
      />
      <div className="card-body">
        <h5 className="card-title">Post</h5>
        <p className="card-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias
          culpa adipisci ex velit saepe maiores, dolores eos ipsam, veniam
          repudiandae deleniti voluptate itaque, accusamus fugit! Exercitationem
          qui officia illum tempore.
        </p>
        <button
          onClick={countLikes}
          type="button"
          className="btn btn-success"
        >
          Likes {pressLike}
        </button>
        <button
          onClick={countHates}
          type="button"
          className="btn btn-danger"
        >
          Hates {pressHate}
        </button>
        <button
          onClick={resetCounters}
          type="button"
          className="btn btn-primary"
        >
          Reset
        </button>
      </div>
    </div>
  );
}
