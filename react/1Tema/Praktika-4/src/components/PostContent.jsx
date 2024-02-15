function PostContent(props) {
  let { title, content, img } = props;
  return (
    <div>
      <h3>{title}</h3>
      <img
        src={img}
        alt={title}
      />
      <p>{content}</p>
    </div>
  );
}

export default PostContent;
