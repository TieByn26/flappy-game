package server.ObjectGson.GsonForClient;

public class CL_GetOtp {
    private int Otp;

    public CL_GetOtp(int otp) {
        Otp = otp;
    }

    public CL_GetOtp() {
    }

    public int getOtp() {
        return Otp;
    }

    public void setOtp(int otp) {
        Otp = otp;
    }
    @Override
    public String toString() {
        return "CL_GetOtp{" +
                "Otp=" + Otp +
                '}';
    }
}
