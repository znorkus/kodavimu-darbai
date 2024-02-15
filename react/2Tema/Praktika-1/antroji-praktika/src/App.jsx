import { useState } from "react";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);

  return;
  <>
    <div
      class="card"
      style="width: 18rem;"
    >
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </p>
        <a
          href="#"
          class="btn btn-primary"
        >
          Go somewhere
        </a>
      </div>
    </div>
  </>;
}

export default App;

// <>
//   <div>
//     <a href="https://vitejs.dev" target="_blank">
//       <img src={viteLogo} className="logo" alt="Vite logo" />
//     </a>
//     <a href="https://react.dev" target="_blank">
//       <img src={reactLogo} className="logo react" alt="React logo" />
//     </a>
//   </div>
//   <h1>Vite + React</h1>
//   <div className="card">
//     <button onClick={() => setCount((count) => count + 1)}>
//       count is {count}
//     </button>
//     <p>
//       Edit <code>src/App.jsx</code> and save to test HMR
//     </p>
//   </div>
//   <p className="read-the-docs">
//     Click on the Vite and React logos to learn more
//   </p>
// </>
