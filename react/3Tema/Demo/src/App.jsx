import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Testing from "./compononts/Testing";
import Actors from "./compononts/Actors";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <Actors />
    </>
  );
}

export default App;
