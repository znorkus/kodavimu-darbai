import { Route, Routes, NavLink } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";
import ErrorPage from "./components/ErrorPage";
export default function App() {
  return (
    <>
      <header>
        <nav>
          <ul>
            <li>
              <NavLink to="/actors">Actors</NavLink>
            </li>
            <li>
              <NavLink to="/movies">Movies</NavLink>
            </li>
            <li>
              <NavLink to="/error">Error Page</NavLink>
            </li>
          </ul>
        </nav>
      </header>
      <main>
        <Routes>
          <Route
            path="/movies"
            element={<Movies />}
          />
          <Route
            path="/actors"
            element={<Actors />}
          />
          <Route
            path="/error"
            element={<ErrorPage />}
          />
        </Routes>
      </main>
    </>
  );
}
