import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function Actor() {
  const [actor, setData] = useState([]);
  const { id } = useParams();

  const getData = async () => {
    const response = await fetch(`http://localhost:8080/actors/${id}`, {
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
            <th scope="col">Name:</th>
            <th scope="col">Age:</th>
            <th scope="col">Height:</th>
            <th scope="col">Salary:</th>
          </tr>
        </thead>

        <tbody>
          <tr key={actor.id}>
            <th>{actor.id}</th>
            <th>{actor.name}</th>
            <th>{actor.age}</th>
            <th>{actor.height}</th>
            <th>{actor.salary}</th>
          </tr>
        </tbody>
      </table>
    </div>
  );
}
