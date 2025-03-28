document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("registerForm");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Ngăn chặn reload trang

        // Lấy dữ liệu từ form
        const formData = new FormData(form);
        const jsonData = {};

        // Chuyển formData thành JSON
        formData.forEach((value, key) => {
            jsonData[key] = value.trim(); // Loại bỏ khoảng trắng thừa
        });

        // Gửi dữ liệu qua API đăng ký tài khoản
        fetch("/api/v1/account/register", {
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
                alert("Đăng ký tài khoản thành công!");
                form.reset(); // Reset form sau khi đăng ký thành công
            })
            .catch(error => {
                console.error("Lỗi:", error);
                alert("Lỗi: " + error.message);
            });
    });

    // Khi người dùng nhấn nút "Tạo công ty"
    const createCompanyButton = document.getElementById("createCompanyButton");
    createCompanyButton.addEventListener("click", function () {
        window.location.href = "/company/register_company.html"; // Điều hướng tới trang register_company.html
    });
});
