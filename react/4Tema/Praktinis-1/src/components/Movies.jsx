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
    <>
      {data.map((movie) => (
        <div key={movie.id}>
          <p>movie id: {movie.id}</p>
          <p>director: {movie.director}</p>
          <p>title: {movie.title}</p>
        </div>
      ))}
    </>
  );
}
