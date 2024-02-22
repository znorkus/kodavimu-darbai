import { useEffect, useState } from "react";

export default function Actors() {
  const [data, setData] = useState([]);

  const getData = async () => {
    const response = await fetch("http://localhost:8080/actors", {
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
    <>
      <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">ID:</th>
            <th scope="col">Name:</th>
            <th scope="col">Age:</th>
            <th scope="col">Height:</th>
            <th scope="col">Salary:</th>
          </tr>
        </thead>
        <tbody>
          {data.map((actor) => (
            <tr key={actor.id}>
              <th>{actor.id}</th>
              <td>{actor.name}</td>
              <td>{actor.age}</td>
              <td>{actor.height}</td>
              <td>{actor.salary}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
