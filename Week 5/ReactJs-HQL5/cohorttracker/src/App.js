import CohortDetails from "./Components/CohortDetails";

function App() {

  return (

    <div>

      <h1>Cognizant Academy Dashboard</h1>

      <CohortDetails
        name="ReactJS Cohort"
        status="Ongoing"
        coach="Rahul Sharma"
        trainer="Priya Singh"
        duration="12 Weeks"
      />

      <CohortDetails
        name="Java FSE Cohort"
        status="Completed"
        coach="Amit Kumar"
        trainer="Neha Gupta"
        duration="10 Weeks"
      />

      <CohortDetails
        name="Spring Boot Cohort"
        status="Ongoing"
        coach="Sanjay Verma"
        trainer="Pooja Mehta"
        duration="8 Weeks"
      />

    </div>

  );

}

export default App;