import "./Box.css";
export default function Box(props) {
  return (
    <>
      <div
        className="box"
        style={{ backgroundColor: props.color }}
      ></div>
    </>
  );
}
