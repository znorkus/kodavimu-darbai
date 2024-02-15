export default function PostImage(props) {
  return (
    <>
      <img
        src={props.src}
        alt={props.alt}
        className="post__image rounded-circle img-fluid"
      />
    </>
  );
}
