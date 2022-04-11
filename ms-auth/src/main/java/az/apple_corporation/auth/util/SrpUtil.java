package az.apple_corporation.auth.util;

import com.nimbusds.srp6.SRP6CryptoParams;
import com.nimbusds.srp6.SRP6ServerSession;
import az.apple_corporation.auth.util.thinbus.HexHashedClientEvidenceRoutine;
import az.apple_corporation.auth.util.thinbus.HexHashedServerEvidenceRoutine;
import az.apple_corporation.auth.util.thinbus.HexHashedURoutine;

public class SrpUtil {
    public static final SRP6CryptoParams CRYPTO_PARAMS =
            new SRP6CryptoParams(SRP6CryptoParams.N_256, SRP6CryptoParams.g_common, "SHA-256");

    public static SRP6ServerSession getSession() {
        SRP6ServerSession session = new SRP6ServerSession(CRYPTO_PARAMS);
        session.setHashedKeysRoutine(new HexHashedURoutine());
        session.setClientEvidenceRoutine(new HexHashedClientEvidenceRoutine());
        session.setServerEvidenceRoutine(new HexHashedServerEvidenceRoutine());
        return session;
    }
}