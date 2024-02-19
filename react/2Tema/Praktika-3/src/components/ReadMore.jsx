import { useState } from "react";

export default function ReadMore({ text, maxLength }) {
  const [readMore, setReadMore] = useState(true);
  const less = text.substring(0, maxLength);

  const showMore = () => {
    setReadMore(!readMore);
  };

  return (
    <div>
      <p>
        {readMore ? less : text}
        <a
          onClick={showMore}
          href="#"
        >
          {readMore ? " ...Show more" : "...Show less"}
        </a>
      </p>
    </div>
  );
}
