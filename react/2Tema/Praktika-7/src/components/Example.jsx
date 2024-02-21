import { useEffect } from "react";

export default function UseEffectFetchData() {
  // const url = "http://api.github.com/users";
  // const [users, setUser] = useState([]);

  const getUsers = async () => {
    const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    const usersData = await response.json();
    setUsers(usersData);
    console.log(users);
  };

  useEffect(() => {
    getUsers();
  }, []);

  return (
    <>
      <p>{users[0].title}</p>
    </>
  );
}
