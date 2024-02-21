import { useForm } from "react-hook-form";

export default function Actors() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    console.log(data);

    const postData = async () => {
      const send = await fetch("http://localhost:8080/actors", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Basic " + btoa("jurgis55:kodas1234"),
        },
        body: JSON.stringify(data),
      });
    };
    postData();
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input
        defaultValue="Name"
        {...register("name")}
      />

      <input
        defaultValue="Age"
        type="number"
        {...register("age")}
      />

      <input
        type="number"
        defaultValue="Height"
        {...register("height")}
      />

      <input
        type="number"
        defaultValue="Salary"
        {...register("salary")}
      />

      <input type="submit" />
    </form>
  );
}
