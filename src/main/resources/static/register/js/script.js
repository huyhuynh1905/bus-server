document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("registerForm").addEventListener("submit", function (event) {
        event.preventDefault(); // Ngăn form gửi đi mặc định

        const data = {
            username: document.getElementById("username").value,
            password: document.getElementById("password").value,
            firstName: document.getElementById("firstName").value,
            lastName: document.getElementById("lastName").value,
            email: document.getElementById("email").value,
            phone: document.getElementById("phone").value,
            jobTitle: document.getElementById("jobTitle").value,
            companyId: document.getElementById("companyId").value
        };

        fetch("/api/auth/register", { // ✅ API xử lý đăng ký
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => {
                if (result.success) {
                    alert("Đăng ký thành công!");
                    window.location.href = "/login"; // Chuyển đến trang đăng nhập
                } else {
                    alert("Lỗi: " + result.message);
                }
            })
            .catch(error => console.error("Lỗi:", error));
    });
});
