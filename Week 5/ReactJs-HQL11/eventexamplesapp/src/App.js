import Counter from "./Components/Counter";
import CurrencyConvertor from "./Components/CurrencyConvertor";

function App() {

  return (

    <div
      style={{
        textAlign: "center",
        marginTop: "30px"
      }}
    >

      <h1>React Event Examples</h1>

      <Counter />

      <hr />

      <CurrencyConvertor />

    </div>

  );

}

export default App;