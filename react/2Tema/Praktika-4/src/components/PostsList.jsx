import { useState } from "react";
import PostContent from "./PostContent";
import data from "../data/list.json";

export default function PostsList() {
  const [posts, setPosts] = useState(data);

  const changeStatus = (id) => {
    const updatePosts = [...posts];
    updatePosts.forEach((post) => {
      if (posts.id === id) {
        posts.status = true;
      }
    });

    setPosts(updatePosts);
  };

  const postsList = posts.map((post) => {
    return (
      <PostContent
        key={post.id}
        id={post.id}
        title={post.title}
        content={post.content}
        img={post.img}
        status={post.status}
        setLearnt={changeStatus}
      />
    );
  });

  return <div className="row">{postsList.length ? postsList : "Empty"}</div>;
}
