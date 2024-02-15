import woods from "../assets/woods.jpg";

export default function PostImage(props) {
  return (
    <>
      <img
        src={props.src}
        alt={props.alt}
        // alt="A view of forest in autumn with red leafs and curvy road in it"
        className="post__image rounded-circle img-fluid"
      />
    </>
  );
}
