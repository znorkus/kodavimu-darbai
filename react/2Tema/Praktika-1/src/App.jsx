import { useState } from "react";
import "./App.css";

export default function App() {
  const [btnPress, setBtnPress] = useState(false);
  function changeBtnPress() {
    setBtnPress(true);
  }
  return (
    <>
      <div
        className="card"
        style={{ width: "18rem" }}
      >
        <div className="card-body">
          <h5 className={btnPress ? "text-success" : "text-danger"}>
            Task is {btnPress ? "DONE!" : "not complete!"}
          </h5>
          <p className="card-text">
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </p>
          <button
            onClick={changeBtnPress}
            type="button"
            className={`btn ${btnPress ? "btn-success" : "btn-danger"}`}
          >
            {btnPress ? "DONE" : "Mark as DONE"}
          </button>
        </div>
      </div>
    </>
  );
}
