import { useEffect, useState } from "react";

export default function Movies() {
  const [data, setData] = useState([]);

  const getData = async () => {
    const response = await fetch("http://localhost:8080/movies", {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("jurgis55:kodas1234") },
    });
    const data = await response.json();
    setData(data);
    console.log(data);
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <table className="table table-dark">
      <thead>
        <tr>
          <th scope="col">ID:</th>
          <th scope="col">Director:</th>
          <th scope="col">Title:</th>
        </tr>
      </thead>
      <tbody>
        {data.map((movie) => (
          <tr key={movie.id}>
            <th>{movie.id}</th>
            <td>{movie.director}</td>
            <td>{movie.title}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
