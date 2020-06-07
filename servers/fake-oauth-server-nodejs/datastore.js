const Data = {};

const Auth = {
  clients: {
    '721927399999-jcihktnuldpplsrk5dbbl4bdngc68rs1.apps.googleusercontent.com': {
      clientId: '721927399999-jcihktnuldpplsrk5dbbl4bdngc68rs1.apps.googleusercontent.com',
      clientSecret: 'TXnxEuxE4RwhwXjemy7E-8xv'
    }
  },
  tokens: {
    'ya29.GlsfBhuqkmgSgFNZM5zqthBuVLsviTJFvf4Q_x0naROr3LCrUhmWJbhmtBIF18iZQPxyNir-b1G-rS-I4BfrXB6VneTVPJbER4WxvMWinfPapcnER40SokxLQsGP': {
      uid: '1234',
      accessToken: 'ya29.GlsfBhuqkmgSgFNZM5zqthBuVLsviTJFvf4Q_x0naROr3LCrUhmWJbhmtBIF18iZQPxyNir-b1G-rS-I4BfrXB6VneTVPJbER4WxvMWinfPapcnER40SokxLQsGP',
      refreshToken: 'ya29.GlsfBhuqkmgSgFNZM5zqthBuVLsviTJFvf4Q_x0naROr3LCrUhmWJbhmtBIF18iZQPxyNir-b1G-rS-I4BfrXB6VneTVPJbER4WxvMWinfPapcnER40SokxLQsGP',
      userId: '1234'
    }
  },
  users: {
    '1234': {
      uid: '1234',
      name: 'rick',
      password: 'oldman',
      tokens: ['ya29.GlsfBhuqkmgSgFNZM5zqthBuVLsviTJFvf4Q_x0naROr3LCrUhmWJbhmtBIF18iZQPxyNir-b1G-rS-I4BfrXB6VneTVPJbER4WxvMWinfPapcnER40SokxLQsGP']
    }
  },
  usernames: {
    'rick': '1234'
  },
  authcodes: {}
};

Data.version = 0;

Data.getUid = function (uid) {
  return Data[uid];
};

/**
 * checks if user and auth exist and match
 *
 * @param uid
 * @param authToken
 * @returns {boolean}
 */
Data.isValidAuth = function (uid, authToken) {
  return (Data.getUid(uid));
};

exports.getUid = Data.getUid;
exports.isValidAuth = Data.isValidAuth;
exports.Auth = Auth;
