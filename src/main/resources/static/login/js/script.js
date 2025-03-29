document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("loginForm");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Ngăn chặn reload trang

        const formData = new FormData(form);
        const jsonData = {};

        formData.forEach((value, key) => {
            jsonData[key] = value.trim(); // Loại bỏ khoảng trắng thừa
        });

        fetch("/api/v1/authentication/authenticate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(jsonData)
        })
            .then(response => {
                if (!response.ok) {
                    return response.json().then(err => {
                        throw new Error(err.message || "Đăng nhập thất bại");
                    });
                }
                return response.json();
            })
            .then(data => {
                alert("Đăng nhập thành công!");
                localStorage.setItem("token", data.token); // Lưu token vào localStorage
                window.location.href = "/dashboard"; // Điều hướng sau khi đăng nhập thành công
            })
            .catch(error => {
                console.error("Lỗi:", error);
                document.getElementById("errorMessage").textContent = error.message;
            });
    });
});
