import { useEffect, useState } from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [choice, setChoice] = useState("");

  const getData = async () => {
    // const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/${choice}`
    );
    const data = await response.json();
    setData(data);
    console.log(data);
  };
  const getData2 = async () => {
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
  }, [choice]);

  useEffect(() => {
    getData2();
  }, []);

  return (
    <>
      <h1>Resources</h1>
      <p>JSONPlaceholder comes with a set of 6 common resources:</p>
      <button onClick={() => setChoice("posts")}>/posts</button>
      <button onClick={() => setChoice("comments")}>/comments</button>
      <button onClick={() => setChoice("albums")}>/albums</button>
      <button onClick={() => setChoice("photos")}>/photos</button>
      <button onClick={() => setChoice("todos")}>/todos</button>
      <button onClick={() => setChoice("users")}>/users</button>
      <button onClick={() => getData2}>/movies</button>
      {choice === "posts" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>user id: {user.userId}</li>
              <li>id: {user.id}</li>
              <li>title: {user.title}</li>
              <li>body: {user.body}</li>
            </ul>
          ))}
        </div>
      )}
      {choice === "comments" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>user id: {user.userId}</li>
              <li>id: {user.id}</li>
              <li>name: {user.name}</li>
              <li>email: {user.email}</li>
              <li>Comment: {user.body}</li>
            </ul>
          ))}
        </div>
      )}
      {choice === "albums" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>user id: {user.userId}</li>
              <li>id: {user.id}</li>
              <li>title: {user.title}</li>
            </ul>
          ))}
        </div>
      )}
      {choice === "photos" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>user id: {user.userId}</li>
              <li>id: {user.id}</li>
              <li>title: {user.title}</li>
              <li>url: {user.url}</li>
              <li>thumbnailurl: {user.thumbnailUrl}</li>
            </ul>
          ))}
        </div>
      )}
      {data.map((movie) => (
        <div key={movie.id}>
          <p>movie id: {movie.id}</p>
          <p>director: {movie.director}</p>
          <p>title: {movie.title}</p>
        </div>
      ))}
      {choice === "todos" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>user id: {user.userId}</li>
              <li>id: {user.id}</li>
              <li>title: {user.title}</li>
              <li>completed: {user.completed}</li>
            </ul>
          ))}
        </div>
      )}
      {choice === "users" && (
        <div>
          {data.map((user) => (
            <ul key={user.id}>
              <li>id: {user.id}</li>
              <li>name: {user.name}</li>
              <li>username: {user.username}</li>
              <li>email: {user.email}</li>
              <li>
                address: {user.address.street}, {user.address.suite},{" "}
                {user.address.city}, {user.address.zipcode}, (
                {user.address.geo.lat}, {user.address.geo.lng})
                <li>phone: {user.phone}</li>
                <li>website: {user.website}</li>
              </li>
              <li>
                company: {user.company.name}, {user.company.catchPhrase},
                {user.company.bs}
              </li>
            </ul>
          ))}
        </div>
      )}
    </>
  );
}
