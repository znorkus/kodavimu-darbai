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

  const deleteData = async (id) => {
    const response = await fetch(`http://localhost:8080/actors/${id}`, {
      method: "DELETE",
      headers: { Authorization: "Basic " + btoa("jurgis55:kodas1234") },
    });
    const updatedData = data.filter((actor) => actor.id !== id);
    setData(updatedData);
  };

  return (
    <div>
      <table className="table table-dark table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">ID:</th>
            <th scope="col">Name:</th>
            <th scope="col">Age:</th>
            <th scope="col">Height:</th>
            <th scope="col">Salary:</th>
            <th scoper="col">Delete:</th>
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
              <td>
                <button onClick={() => deleteData(actor.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
