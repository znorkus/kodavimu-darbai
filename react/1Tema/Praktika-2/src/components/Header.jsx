import "./Header.css";
export default function Header() {
  return (
    <div className="header">
      <h1>Pagrindinė antraštė</h1>
      <img
        src="https://images.pexels.com/photos/300857/pexels-photo-300857.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        alt="View of lake in winter with ice on top and mountains in horizon"
        className="header__img w-100 object-fit-cover mb-3"
      ></img>
    </div>
  );
}
