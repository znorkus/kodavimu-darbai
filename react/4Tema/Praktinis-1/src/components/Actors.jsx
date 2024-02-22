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
      {data.map((actor) => (
        <div key={actor.id}>
          <p>name: {actor.name}</p>
          <p>age: {actor.age}</p>
          <p>height: {actor.height}</p>
          <p>salary: {actor.salary}</p>
        </div>
      ))}
    </>
  );
}
