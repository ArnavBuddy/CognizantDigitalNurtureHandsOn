import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    return (

        <div className={styles.box}>

            <h2>{props.name}</h2>

            <h3
                style={{
                    color:
                        props.status === "Ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {props.status}
            </h3>

            <dl>

                <dt>Coach</dt>
                <dd>{props.coach}</dd>

                <dt>Trainer</dt>
                <dd>{props.trainer}</dd>

                <dt>Duration</dt>
                <dd>{props.duration}</dd>

            </dl>

        </div>

    );

}

export default CohortDetails;