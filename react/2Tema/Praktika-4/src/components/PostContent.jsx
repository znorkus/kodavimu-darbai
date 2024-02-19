function PostContent({ title, content, setLearnt, id, status, img }) {
  return (
    <div className="col-4">
      <h3>{title}</h3>
      <img
        src={img}
        alt={title}
      />
      <p>{content}</p>
      <p>{status ? "Išmokau" : "Mokausi"}</p>
      <button onClick={() => setLearnt(id)}>OK</button>
    </div>
  );
}

export default PostContent;
