function CourseDetails() {

    const courses = [

        {
            id: 1,
            name: "ReactJS",
            duration: "6 Weeks"
        },

        {
            id: 2,
            name: "Spring Boot",
            duration: "8 Weeks"
        },

        {
            id: 3,
            name: "Python",
            duration: "5 Weeks"
        }

    ];

    return (

        <div>

            <h2>Course Details</h2>

            {

                courses.map((course) => (

                    <div
                        key={course.id}
                        style={{
                            border: "1px solid black",
                            padding: "10px",
                            marginBottom: "10px",
                            width: "300px"
                        }}
                    >

                        <h3>{course.name}</h3>

                        <p>

                            Duration : {course.duration}

                        </p>

                    </div>

                ))

            }

        </div>

    );

}

export default CourseDetails;