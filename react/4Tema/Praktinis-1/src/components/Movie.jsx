import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function Movie() {
  const [movie, setData] = useState([]);
  const { id } = useParams();

  const getData = async () => {
    const response = await fetch(`http://localhost:8080/movies/${id}`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("jurgis55:kodas1234") },
    });
    const data = await response.json();
    setData(data);
    console.log(data);
  };

  useEffect(() => {
    getData();
  }, [id]);

  return (
    <div>
      <table className="table table-striper table-dark table-hover">
        <thead>
          <tr>
            <th scope="col">Id:</th>
            <th scope="col">Director:</th>
            <th scope="col">Title:</th>
            <th scope="col">Director:</th>
            <th scope="col">Date Release:</th>
            <th scope="col">Length in Minutes:</th>
          </tr>
        </thead>

        <tbody>
          <tr key={movie.id}>
            <th>{movie.id}</th>
            <th>{movie.director}</th>
            <th>{movie.title}</th>
            <th>{movie.director}</th>
            <th>{movie.dateRelease}</th>
            <th>{movie.lengthMinutes}</th>
          </tr>
        </tbody>
      </table>
    </div>
  );
}
