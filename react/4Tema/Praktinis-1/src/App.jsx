import { Route, Routes, NavLink } from "react-router-dom";
import Movies from "./components/Movies";
import Actors from "./components/Actors";
import ErrorPage from "./components/ErrorPage";
import Movie from "./components/Movie";
import Actor from "./components/Actor";
export default function App() {
  return (
    <div className="container">
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
            path="*"
            element={<ErrorPage />}
          />
          <Route
            path="/movies/:id"
            element={<Movie />}
          />
          <Route
            path="/actors/:id"
            element={<Actor />}
          />
        </Routes>
      </main>
    </div>
  );
}
