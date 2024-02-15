import "./Header.css";

export default function Header(props) {
  // console.log(props);

  return (
    <div className="header">
      <h1 className="header__title">{props.title}</h1>
      <img
        src={props.src}
        alt="View of snowy mountains and red sky on sunset"
        className="header__img w-100 object-fit-cover mb-3"
      />
      <p>{props.content}</p>
    </div>
  );
}
