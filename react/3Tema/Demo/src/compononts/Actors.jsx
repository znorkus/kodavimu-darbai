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
    <div>
      POST TO ACTORS DATABASE
      <form onSubmit={handleSubmit(onSubmit)}>
        <input
          placeholder="Name"
          // defaultValue="Name"
          {...register("name", { required: true, minLength: 2 })}
        />
        {errors.name && errors.name.type === "required" && (
          <span>Name field is required</span>
        )}
        {errors.name && errors.name.type === "minLength" && (
          <span>Name must be at least 2 characters long</span>
        )}
        <br></br>
        <input
          type="number"
          // defaultValue="10"
          placeholder="Age"
          {...register("age", { required: true, min: 5 })}
        />
        {errors.name && errors.name.type === "required" && (
          <span>Age field is required</span>
        )}
        {errors.age && errors.age.type === "min" && (
          <span>Actor must be at least 5 year old</span>
        )}
        <br></br>
        <input
          type="number"
          // defaultValue="10"
          placeholder="Height"
          {...register("height", { required: true, min: 50 })}
        />
        {errors.height && errors.height.type === "required" && (
          <span>Height field is required</span>
        )}
        {errors.height && errors.height.type === "min" && (
          <span>Actor must be at least 50 centimeters tall</span>
        )}
        <br></br>
        <input
          type="number"
          // defaultValue="10"
          placeholder="Salary"
          {...register("salary", { required: true, min: 1 })}
        />
        {errors.salary && errors.salary.type === "required" && (
          <span>Salary field is required</span>
        )}
        {errors.salary && errors.salary.type === "min" && (
          <span>Actor's salary must be at least 1usd.</span>
        )}
        <br></br>
        <input type="submit" />
      </form>
    </div>
  );
}
