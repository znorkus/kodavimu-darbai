import { Route, Routes, NavLink } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";
import ErrorPage from "./components/ErrorPage";
import Movie from "./components/Movie";
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
          </ul>
        </nav>
      </header>
      <main className="container">
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
            path="*"
            element={<ErrorPage />}
          />
          <Route
            path="/movies/:id"
            element={<Movie />}
          />
        </Routes>
      </main>
    </>
  );
}
