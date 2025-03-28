document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("registerForm");

    // Kiểm tra xem form có tồn tại không
    if (!form) {
        console.error("Form không tìm thấy.");
        return;
    }

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Ngăn chặn reload trang

        const formData = new FormData(form);
        const jsonData = {};

        // Chuyển form data thành object
        formData.forEach((value, key) => {
            jsonData[key] = value.trim(); // Loại bỏ khoảng trắng thừa
        });

        console.log("Dữ liệu gửi đi:", jsonData); // Kiểm tra dữ liệu gửi đi

        fetch("/api/v1/company/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(jsonData)
        })
            .then(response => {
                if (!response.ok) {
                    return response.json().then(err => {
                        throw new Error(err.messages?.join(", ") || "Đăng ký không thành công");
                    });
                }
                return response.json();
            })
            .then(data => {
                alert("Đăng ký công ty thành công!");
                form.reset();
            })
            .catch(error => {
                console.error("Lỗi:", error);
                alert("Lỗi: " + error.message);
            });
    });
});
