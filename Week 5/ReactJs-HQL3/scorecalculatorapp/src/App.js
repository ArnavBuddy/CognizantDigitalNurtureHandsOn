import CalculateScore from "./Components/CalculateScore";

function App() {

  return (
    <div>
      <CalculateScore
        name="Abhyanand Sharma"
        school="VIT Bhopal University"
        total={450}
        goal={5}
      />
    </div>
  );

}

export default App;