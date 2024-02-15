import Header from "./components/Header";
import PostImage from "./components/PostImage";
import PostContent from "./components/PostContent";
import Box from "./components/Box";

function App() {
  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <Header
            title="Labas, aš mokausi"
            src="src/assets/switzerland.jpg"
            content="Man patinka React"
          />
          <div className="row">
            <div className="col-6 text-center">
              <PostImage
                src="src/assets/woods.jpg"
                alt="A view of forest in autumn with red leafs and curvy road in it"
              />
              <PostContent h3="H3 Tekstas" />
            </div>
            <div className="col-6 text-center">
              <PostImage
                src="src/assets/autumn.jpeg"
                alt="A view of forest in autumn"
              />
              <PostContent h3="H3 Tekstas" />
            </div>
            <div className="row">
              <div className="col-3">
                <Box color="black" />
              </div>
              <div className="col-3">
                <Box color="green" />
              </div>
              <div className="col-3">
                <Box color="blue" />
              </div>
              <div className="col-3">
                <Box color="purple" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
